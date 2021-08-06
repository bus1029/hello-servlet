package hello.servlet.web.frontcontroller.v3.controller

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.frontcontroller.v2.ControllerV2
import hello.servlet.web.frontcontroller.v3.ControllerV3
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV3 : ControllerV3 {
  override fun process(paramMap: Map<String, String>): ModelView {
    return ModelView("new-form")
  }
}