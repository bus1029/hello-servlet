package hello.servlet.web.frontcontroller

class ModelView constructor(var viewName: String) {
  val model = HashMap<String, Any?>()
}