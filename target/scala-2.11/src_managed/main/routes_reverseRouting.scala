// @SOURCE:/Users/sromic/play/GitWsDemo/conf/routes
// @HASH:0a8f4347d99395dc4e4a27a6411882ba5030a916
// @DATE:Thu Jun 11 23:55:38 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:12
class ReverseAssets {


// @LINE:12
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:9
def gitSearchCode(q:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "searchCode" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)))))
}
                        

// @LINE:8
def gitSearchRespositories(q:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "searchRepositories" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)))))
}
                        

// @LINE:7
def index2(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "index2")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:12
class ReverseAssets {


// @LINE:12
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:9
def gitSearchCode : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.gitSearchCode",
   """
      function(q) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchCode" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q)])})
      }
   """
)
                        

// @LINE:8
def gitSearchRespositories : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.gitSearchRespositories",
   """
      function(q) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchRepositories" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q)])})
      }
   """
)
                        

// @LINE:7
def index2 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index2",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index2"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:12
class ReverseAssets {


// @LINE:12
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:9
def gitSearchCode(q:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.gitSearchCode(q), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "gitSearchCode", Seq(classOf[String]), "GET", """""", _prefix + """searchCode""")
)
                      

// @LINE:8
def gitSearchRespositories(q:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.gitSearchRespositories(q), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "gitSearchRespositories", Seq(classOf[String]), "GET", """""", _prefix + """searchRepositories""")
)
                      

// @LINE:7
def index2(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index2(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index2", Seq(), "GET", """""", _prefix + """index2""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    