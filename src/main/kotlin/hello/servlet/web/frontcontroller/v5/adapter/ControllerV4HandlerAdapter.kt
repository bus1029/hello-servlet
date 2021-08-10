package hello.servlet.web.frontcontroller.v5.adapter

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v3.ControllerV3
import hello.servlet.web.frontcontroller.v4.ControllerV4
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV4HandlerAdapter : MyHandlerAdapter {
  override fun supports(handler: Any?): Boolean {
    return handler is ControllerV4
  }

  override fun handle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): ModelView {
    val controller = handler as? ControllerV4
    val paramMap = createParamMap(request)
    val model = HashMap<String, Any?>()
    val logicalViewName = controller?.process(paramMap, model) ?: ""
    val modelView = ModelView(logicalViewName)
    modelView.model = model
    return modelView
  }

  private fun createParamMap(request: HttpServletRequest?): HashMap<String, String> {
    val paramMap = HashMap<String, String>()
    request?.parameterNames
      ?.asIterator()?.forEachRemaining {
        paramMap[it] = request.getParameter(it)
      }
    return paramMap
  }

  private fun resolveViewPath(viewPathPrefix: String, modelView: String): MyView {
    return MyView("$viewPathPrefix/${modelView}.jsp")
  }
}