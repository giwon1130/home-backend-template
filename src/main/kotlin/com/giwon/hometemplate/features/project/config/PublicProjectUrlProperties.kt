package com.giwon.hometemplate.features.project.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(PublicProjectUrlProperties::class)
class PublicProjectUrlConfig

@ConfigurationProperties(prefix = "app.public.urls")
data class PublicProjectUrlProperties(
    var home: String = "http://localhost:4173",
    var assistant: String = "http://localhost:4173/assistant",
    var homeHarmony: String = "http://127.0.0.1:4174",
    var routeOps: String = "http://localhost:4173",
    var signalDesk: String = "http://localhost:4180",
)
