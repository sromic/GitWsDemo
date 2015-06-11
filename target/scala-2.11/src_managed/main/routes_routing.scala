// @SOURCE:/Users/sromic/play/GitWsDemo/conf/routes
// @HASH:0a8f4347d99395dc4e4a27a6411882ba5030a916
// @DATE:Thu Jun 11 23:55:38 CEST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_index21_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("index2"))))
private[this] lazy val controllers_Application_index21_invoker = createInvoker(
controllers.Application.index2,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index2", Nil,"GET", """""", Routes.prefix + """index2"""))
        

// @LINE:8
private[this] lazy val controllers_Application_gitSearchRespositories2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("searchRepositories"))))
private[this] lazy val controllers_Application_gitSearchRespositories2_invoker = createInvoker(
controllers.Application.gitSearchRespositories(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "gitSearchRespositories", Seq(classOf[String]),"GET", """""", Routes.prefix + """searchRepositories"""))
        

// @LINE:9
private[this] lazy val controllers_Application_gitSearchCode3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("searchCode"))))
private[this] lazy val controllers_Application_gitSearchCode3_invoker = createInvoker(
controllers.Application.gitSearchCode(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "gitSearchCode", Seq(classOf[String]),"GET", """""", Routes.prefix + """searchCode"""))
        

// @LINE:12
private[this] lazy val controllers_Assets_at4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """index2""","""controllers.Application.index2"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """searchRepositories""","""controllers.Application.gitSearchRespositories(q:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """searchCode""","""controllers.Application.gitSearchCode(q:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:7
case controllers_Application_index21_route(params) => {
   call { 
        controllers_Application_index21_invoker.call(controllers.Application.index2)
   }
}
        

// @LINE:8
case controllers_Application_gitSearchRespositories2_route(params) => {
   call(params.fromQuery[String]("q", None)) { (q) =>
        controllers_Application_gitSearchRespositories2_invoker.call(controllers.Application.gitSearchRespositories(q))
   }
}
        

// @LINE:9
case controllers_Application_gitSearchCode3_route(params) => {
   call(params.fromQuery[String]("q", None)) { (q) =>
        controllers_Application_gitSearchCode3_invoker.call(controllers.Application.gitSearchCode(q))
   }
}
        

// @LINE:12
case controllers_Assets_at4_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     