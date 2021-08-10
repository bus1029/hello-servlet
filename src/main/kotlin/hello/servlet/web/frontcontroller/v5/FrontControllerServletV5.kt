package hello.servlet.web.frontcontroller.v5

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV5", urlPatterns = ["/front-controller/v5/*"])
class FrontControllerServletV5 : HttpServlet() {
  private val handlerMappingMap = HashMap<String, Any?>()
  private val handlerAdapters = ArrayList<MyHandlerAdapter>()

  init {
    initHandlerMappingMap()
    initHandlerAdapters()
  }

  private fun initHandlerMappingMap() {
    handlerMappingMap["/front-controller/v5/v3/members/new-form"] = MemberFormControllerV3()
    handlerMappingMap["/front-controller/v5/v3/members/save"] = MemberSaveControllerV3()
    handlerMappingMap["/front-controller/v5/v3/members"] = MemberListControllerV3()
  }

  private fun initHandlerAdapters() {
    handlerAdapters.add(ControllerV3HandlerAdapter())
  }

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    val handler = getHandler(request, response)
    if (handler is HttpServletResponse) {
      return
    }

    val handlerAdapter = getHandlerAdapter(handler)
    val modelView = handlerAdapter.handle(request, response, handler)
    val viewPathPrefix = "/WEB-INF/views"
    val myView = resolveViewPath(viewPathPrefix, modelView)
    myView.render(modelView.model, request, response)
  }

  private fun getHandler(request: HttpServletRequest?, response: HttpServletResponse?): Any {
    val requestURI = request?.requestURI
    val controller = handlerMappingMap[requestURI] ?: kotlin.run {
      response?.status = HttpServletResponse.SC_NOT_FOUND
      return response!!
    }

    return controller
  }

  private fun getHandlerAdapter(handler: Any): MyHandlerAdapter {
    for (handlerAdapter in handlerAdapters) {
      if (handlerAdapter.supports(handler)) {
        return handlerAdapter
      }
    }

    throw IllegalArgumentException("handler adapter not found. handler=$handler")
  }

  private fun resolveViewPath(viewPathPrefix: String, modelView: ModelView): MyView {
    return MyView("$viewPathPrefix/${modelView.viewName}.jsp")
  }
}