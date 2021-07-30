package hello.servlet.basic.request

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = ["/request-param"])
class RequestParamServlet : HttpServlet() {
  override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
    req?.also {
      println("[전체 파라미터 조회] - start")
      req.parameterNames?.asIterator()
        ?.forEachRemaining { paramName ->
          println("$paramName = ${req.getParameter(paramName)}")
        }
      println("[전체 파라미터 조회] - end")
      println()

      println("[단일 파라미터 조회] - start")
      val username = req.getParameter("username")
      val age = req.getParameter("age")
      println("username = $username")
      println("age = $age")
      println("[단일 파라미터 조회] - end")
      println()

      println("[이름이 같은 복수 파라미터 조회] - start")
      val userNames = req.getParameterValues("username")
      for (userName in userNames) {
        println("userName = $userName")
      }
      println("[이름이 같은 복수 파라미터 조회] - end")
      println()
    }
  }
}