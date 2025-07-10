package com.RestfulApi.TeacherInformationSystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Teacher Information System API")
                .version("1.0.0")
                .description("Öğretmen Bilgi Sistemi için RESTful API dokümantasyonu.\n\n" +
                        "### Örnek Kullanımlar\n" +
                        "- Tüm öğretmenleri listele: `/api/teachers`\n" +
                        "- Yeni öğrenci ekle: `/api/students` (POST)\n" +
                        "- Sınıfa öğrenci ata: `/api/classes/{classId}/students` (PUT)\n" +
                        "- Yöneticileri ara: `/api/managers?name=Ali`\n\n" +
                        "Her endpoint için detaylı örnekler Swagger UI'da görülebilir.")
                .contact(new Contact()
                    .name("Erwin Ya")
                    .email("erwinya@example.com")
                    .url("https://github.com/erwinya"))
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT"))
            )
            .servers(List.of(
                new Server().url("http://localhost:8080").description("Local Geliştirme Sunucusu"),
                new Server().url("https://api.teacherinfo.com").description("Canlı Sunucu")
            ));
    }
}
