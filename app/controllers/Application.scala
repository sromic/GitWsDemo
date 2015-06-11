package controllers

import play.api.Play.current
import play.api.libs.iteratee.Enumerator
import play.api.libs.ws.WS
import play.api.mvc.{Action, Controller, ResponseHeader, Result}
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  /**
   * Creates the same as index method
   * This is manual creation of header and content body
   */
  def index2 = Action {
    Result(
      header = ResponseHeader(200, Map(CONTENT_TYPE -> "text/plain")),
      body = Enumerator("Hello world".getBytes())
    )
  }

/*
  implicit val repositoryReads: Reads[Repository] = (
      (JsPath \ "id").read[BigInt] and
      (JsPath \ "name").read[String] and
      (JsPath \ "url").read[String] and
      (JsPath \ "description").read[String]
    ) (Repository.apply _)

  implicit val respositorySearchResultReads: Reads[RepositorySearchResult] = (
    (JsPath \ "total_counts").read[BigInt] and
      (JsPath \ "items").read[List[Repository]]
    )(RepositorySearchResult.apply _)
*/

  /**
   * Not implemented
   * @param q
   * @return returning default not implemented page
   */
  def gitSearchRespositories(q: String) = Action.async {
    WS.url("https://api.github.com/search/repositories").withQueryString("q" -> q).withRequestTimeout(5000).get.map {
      response => Ok(response.json)
    }
  }

  /**
   * Search GitHub for code
   * @param q
   * @return
   */
  def gitSearchCode(q: String) = Action.async {
    WS.url("https://api.github.com/search/code").withQueryString("q" -> q).withRequestTimeout(5000).get.map {
      response => Ok(response.json)
    }
  }


  /**
   * Search GitHub for users
   * @param q
   * @return
   */
  def gitSearchUsers(q: String) = Action.async {
    WS.url("https://api.github.com/search/users").withQueryString("q" -> q).withRequestTimeout(5000).get.map {
      response => Ok(response.json)
    }
  }

}