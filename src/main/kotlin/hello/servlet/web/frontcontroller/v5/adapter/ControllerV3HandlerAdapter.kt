package hello.servlet.web.frontcontroller.v5.adapter

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV3HandlerAdapter : MyHandlerAdapter {
  override fun supports(handler: Any?): Boolean {
    return handler is ControllerV3
  }

  override fun handle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): ModelView {
    val controller = handler as? ControllerV3
    val paramMap = createParamMap(request)
    return controller?.process(paramMap) ?: ModelView("index")
  }

  private fun createParamMap(request: HttpServletRequest?): HashMap<String, String> {
    val paramMap = HashMap<String, String>()
    request?.parameterNames
      ?.asIterator()?.forEachRemaining {
        paramMap[it] = request.getParameter(it)
      }
    return paramMap
  }
}