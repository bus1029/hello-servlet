package hello.servlet.basic.response

import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "responseHeaderServlet", urlPatterns = ["/response-header"])
class ResponseHeaderServlet : HttpServlet() {
  override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
    resp?.also {
      // Status-line
      resp.status = HttpServletResponse.SC_OK
      // Response-header
      setContentType(resp)
      resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
      resp.setHeader("Pragma", "no-cache")
      resp.setHeader("my-header", "hello")
      setCookie(resp)
      setRedirect(resp)
      // Message body
      resp.writer.println("OK")
    }
  }

  private fun setContentType(resp: HttpServletResponse) {
    resp.contentType = "text/plain"
    resp.characterEncoding = "utf-8"
  }

  private fun setCookie(resp: HttpServletResponse) {
    val cookie = Cookie("myCookie", "good")
    cookie.maxAge = 600
    resp.addCookie(cookie)
  }

  private fun setRedirect(resp: HttpServletResponse) {
    resp.sendRedirect("/basic/hello-form.html")
  }
}