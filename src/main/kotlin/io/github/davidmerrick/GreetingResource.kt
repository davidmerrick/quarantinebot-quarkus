package io.github.davidmerrick

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/greeting")
class GreetingResource @Inject constructor(
        private val greetingService: GreetingService
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello() = Greeting("hello")

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun greetByName(@PathParam("name") name: String): Greeting {
        return Greeting(greetingService.greeting(name))
    }
}
