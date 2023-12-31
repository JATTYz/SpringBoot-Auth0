package com.auth0.controller

import com.auth0.model.Message
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["api"])
// For simplicity of this sample, allow all origins. Real applications should configure CORS for their use case.
@CrossOrigin(origins = ["*"])
class Controller {

    @GetMapping(value = ["/public"])
    fun publicEndpoint(): Message? {
        return Message("All good. You DO NOT need to be authenticated to call /api/public.")
    }

    @GetMapping(value = ["/private"])
    fun privateEndpoint(): Message? {
        return Message("All good. You can see this because you are Authenticated.")
    }

    @GetMapping(value = ["/private-scoped"])
    fun privateScopedEndpoint(): Message? {
        return Message("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope")
    }
}