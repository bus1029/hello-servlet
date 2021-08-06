package hello.servlet.web.frontcontroller.v2

import hello.servlet.web.frontcontroller.MyView
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.jvm.Throws

interface ControllerV2 {
  @Throws(ServletException::class, IOException::class)
  fun process(request: HttpServletRequest?, response: HttpServletResponse?): MyView
}