import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("Your new application is ready.")
    }

    "render the index2 page" in new WithApplication {
      val home = route(FakeRequest(GET, "/index2")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/plain")
      contentAsString(home) must contain ("Hello world")
    }

    "render the git page" in new WithApplication {
      val gitPage = route(FakeRequest(GET, "/searchRepositories?q=hello world")).get

      status(gitPage) must equalTo(NOT_IMPLEMENTED)
      contentType(gitPage) must beSome.which(_ == "text/html")
      contentAsString(gitPage) must contain ("Action not implemented yet")

    }
  }
}
