package hello.servlet.web.frontcontroller.v3

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.jvm.Throws

interface ControllerV3 {
  @Throws(ServletException::class, IOException::class)
  fun process(paramMap: Map<String, String>): ModelView
}