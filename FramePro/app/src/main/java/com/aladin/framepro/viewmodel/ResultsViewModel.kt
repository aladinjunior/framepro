package com.aladin.framepro.viewmodel

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.AndroidViewModel
import com.aladin.framepro.R
import com.aladin.framepro.domain.model.Register
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

import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject


@HiltViewModel
class ResultsViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {


    fun createPdf(context: Context, register: Register) {
        val pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
        val file = File(pdfPath, "frames.pdf")
        val outputStream = FileOutputStream(file)
        val pdfWriter = PdfWriter(file)
        val pdfDocument = PdfDocument(pdfWriter)
        val document = Document(pdfDocument)

        pdfDocument.defaultPageSize = PageSize.A4

        document.setMargins(0f, 0f, 0f, 0f)

        val drawable = AppCompatResources.getDrawable(context, R.drawable.house_pdf)
        val bitmap = drawable?.toBitmap()

        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream)

        val bitmapData = stream.toByteArray()

        val imageData = ImageDataFactory.create(bitmapData)
        val image = Image(imageData)

        val registerName = Paragraph(register.name).setBold().setFontSize(24f).setTextAlignment(TextAlignment.CENTER)


        val width = floatArrayOf(100f, 100f)

        val table = Table(width)


        table.setHorizontalAlignment(HorizontalAlignment.CENTER)

        table.addCell(Cell().add(Paragraph("teu cu porra")))

        document.add(image)
        document.add(registerName)
        document.add(table)
        document.close()
        Toast.makeText(context, "PDF CRIADO", Toast.LENGTH_SHORT).show()
    }

}