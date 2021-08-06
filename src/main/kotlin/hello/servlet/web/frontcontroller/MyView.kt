package hello.servlet.web.frontcontroller

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.jvm.Throws

class MyView constructor(private var viewPath: String = "") {
  @Throws(ServletException::class, IOException::class)
  fun render(request: HttpServletRequest?, response: HttpServletResponse?) {
    val requestDispatcher = request?.getRequestDispatcher(viewPath)
    requestDispatcher?.forward(request, response)
  }
}