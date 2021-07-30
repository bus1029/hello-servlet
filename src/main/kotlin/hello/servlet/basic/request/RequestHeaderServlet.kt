package hello.servlet.basic.request

import java.util.*
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet : HttpServlet() {
  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    request?.also {
      printStartLine(request)
      printHeaders(request)
      printHeaderUtils(request)
      printEtc(request)
    }
  }

  private fun printStartLine(request: HttpServletRequest) {
    println("--- REQUEST-LINE - start ---");
    println("request.getMethod() = " + request.method); //GET
    println("request.getProtocal() = " + request.protocol); //
    println("request.getScheme() = " + request.scheme); //http
    // http://localhost:8080/request-header
    println("request.getRequestURL() = " + request.requestURL);
    // /request-test
    println("request.getRequestURI() = " + request.requestURI);
    //username=hi
    println("request.getQueryString() = " + request.queryString);
    println("request.isSecure() = " + request.isSecure); //https
    println("--- REQUEST-LINE - end ---");
    println();
  }

  private fun printHeaders(request: HttpServletRequest) {
    println("--- Headers - start ---")
    val headerNames = request.headerNames
    headerNames?.asIterator()?.forEachRemaining { headerName ->
      println("headerName = $headerName")
    }
    println("--- Headers - end ---")
    println()
  }

  private fun printHeaderUtils(request: HttpServletRequest) {
    println("--- Header 편의 조회 start ---")
    println("[Host 편의 조회]")
    println(
      "request.getServerName() = " +
              request.serverName
    ) //Host 헤더
    println(
      "request.getServerPort() = " +
              request.serverPort
    ) //Host 헤더
    println()

    println("[Accept-Language 편의 조회]")
    request.locales.asIterator()
      .forEachRemaining { locale: Locale ->
        println(
          "locale = " +
                  locale
        )
      }
    // 가장 높은 우선순위의 locale 을 가져옴
    println("request.getLocale() = " + request.locale)
    println()
    println("[cookie 편의 조회]")
    if (request.cookies != null) {
      for (cookie in request.cookies) {
        println(cookie.name.toString() + ": " + cookie.value)
      }
    }
    println()

    println("[Content 편의 조회]")
    println(
      "request.getContentType() = " +
              request.contentType
    )
    println(
      "request.getContentLength() = " +
              request.contentLength
    )
    println(
      "request.getCharacterEncoding() = " +
              request.characterEncoding
    )
    println("--- Header 편의 조회 end ---")
    println()
  }

  private fun printEtc(request: HttpServletRequest) {
    println("--- 기타 조회 start ---")
    println("[Remote 정보]")
    println(
      "request.getRemoteHost() = " +
              request.remoteHost
    ) //
    println(
      "request.getRemoteAddr() = " +
              request.remoteAddr
    ) //
    println(
      "request.getRemotePort() = " +
              request.remotePort
    ) //
    println()

    println("[Local 정보]")
    println(
      "request.getLocalName() = " +
              request.localName
    ) //
    println(
      "request.getLocalAddr() = " +
              request.localAddr
    ) //
    println(
      "request.getLocalPort() = " +
              request.localPort
    ) //
    println("--- 기타 조회 end ---")
    println()
  }
}