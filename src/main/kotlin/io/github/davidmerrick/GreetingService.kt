package io.github.davidmerrick

import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class GreetingService {

    fun greeting(name: String) = "Hello $name"
}