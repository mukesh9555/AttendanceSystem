package servlet;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/generateQR")
public class QRCodeServlet extends HttpServlet {
    private static final int QR_WIDTH = 250;
    private static final int QR_HEIGHT = 250;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String data = req.getParameter("data");
        
        if (data == null || data.trim().isEmpty()) {
            data = "attendance:sample";
        }
        
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                data, 
                BarcodeFormat.QR_CODE, 
                QR_WIDTH, 
                QR_HEIGHT
            );
            
            res.setContentType("image/png");
            res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            res.setHeader("Pragma", "no-cache");
            res.setDateHeader("Expires", 0);
            
            MatrixToImageWriter.writeToStream(matrix, "PNG", res.getOutputStream());
            res.getOutputStream().flush();
            
        } catch (WriterException e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            res.setContentType("text/plain");
            res.getWriter().write("Error generating QR Code: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            res.setContentType("text/plain");
            res.getWriter().write("IO Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
