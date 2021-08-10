package hello.servlet.web.frontcontroller.v4

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV4", urlPatterns = ["/front-controller/v4/*"])
class FrontControllerServletV4 : HttpServlet() {
  private val controllerMap = HashMap<String, ControllerV4>()

  init {
    controllerMap["/front-controller/v4/members/new-form"] = MemberFormControllerV4()
    controllerMap["/front-controller/v4/members/save"] = MemberSaveControllerV4()
    controllerMap["/front-controller/v4/members"] = MemberListControllerV4()
  }

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    println("FrontControllerServletV4.service")

    val requestURI = request?.requestURI
    val controller = controllerMap[requestURI] ?: kotlin.run {
      response?.status = HttpServletResponse.SC_NOT_FOUND
      return
    }

    val paramMap = createParamMap(request)
    val model = HashMap<String, Any?>()
    val modelView = controller.process(paramMap, model)
    val viewPathPrefix = "/WEB-INF/views"
    val myView = resolveViewPath(viewPathPrefix, modelView)
    myView.render(model, request, response)
  }

  private fun resolveViewPath(viewPathPrefix: String, modelView: String): MyView {
    return MyView("$viewPathPrefix/${modelView}.jsp")
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