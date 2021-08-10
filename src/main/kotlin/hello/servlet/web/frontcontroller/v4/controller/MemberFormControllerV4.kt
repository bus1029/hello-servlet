package hello.servlet.web.frontcontroller.v4.controller

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.frontcontroller.v2.ControllerV2
import hello.servlet.web.frontcontroller.v3.ControllerV3
import hello.servlet.web.frontcontroller.v4.ControllerV4
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV4 : ControllerV4 {
  override fun process(paramMap: Map<String, String>, model: HashMap<String, Any?>): String {
    return "new-form"
  }
}