package tech.donau.course

import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {

    @ConfigProperty(name = "greeting.name")

    fun greet (name: String) = "Hello $name"
}