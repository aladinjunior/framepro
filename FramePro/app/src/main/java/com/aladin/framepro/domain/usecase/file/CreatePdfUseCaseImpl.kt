package com.aladin.framepro.domain.usecase.file

import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import com.aladin.framepro.R
import com.aladin.framepro.domain.model.Register
import com.aladin.framepro.extensions.createFramesNameTemplate
import com.itextpdf.io.image.ImageDataFactory
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.properties.HorizontalAlignment
import com.itextpdf.layout.properties.TextAlignment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class CreatePdfUseCaseImpl @Inject constructor() : CreatePdfUseCase {

    override suspend fun invoke(context: Context, register: Register) {
        val pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            .toString()
        val stringDate = System.currentTimeMillis().toString()
        val file = File(pdfPath, "${stringDate}.pdf")
        withContext(Dispatchers.IO) {
            FileOutputStream(file)
        }
        val pdfWriter = PdfWriter(file)
        val pdfDocument = PdfDocument(pdfWriter)
        val document = Document(pdfDocument)

        pdfDocument.defaultPageSize = PageSize.A6

        with(document){
            setMargins(0f, 0f, 0f, 0f)

            val drawable = AppCompatResources.getDrawable(context, R.drawable.house_pdf)
            val bitmap = drawable?.toBitmap()

            val stream = ByteArrayOutputStream()
            bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream)

            val bitmapData = stream.toByteArray()

            val imageData = ImageDataFactory.create(bitmapData)
            val image = Image(imageData)

            val registerName = Paragraph(context.getString(R.string.document)).setBold().setFontSize(24f)
                .setTextAlignment(TextAlignment.CENTER)


            val width = floatArrayOf(100f, 100f)

            val table = Table(width)

            table.setHorizontalAlignment(HorizontalAlignment.CENTER)

            with(table){
                addCell(Cell().add(Paragraph(context.getString(R.string.name))))
                addCell(Cell().add(Paragraph(register.name)))
                addCell(Cell().add(Paragraph(context.getString(R.string.address))))
                addCell(Cell().add(Paragraph(register.address)))
                addCell(Cell().add(Paragraph(context.getString(R.string.frames))))
                val frameTable = Paragraph()
                for(frame in register.frames){
                    frameTable.add(createFramesNameTemplate(frame))
                }

                addCell(Cell().add(frameTable))
            }



            add(image)
            add(registerName)
            add(table)
            close()
        }

        withContext(Dispatchers.Main){
            Toast.makeText(context, context.getString(R.string.created_pdf), Toast.LENGTH_SHORT).show()

        }
    }
}