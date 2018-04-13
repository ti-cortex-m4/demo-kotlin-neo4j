package demo

import org.neo4j.ogm.session.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableNeo4jRepositories(basePackages = arrayOf("demo.neo4j.repository"))
@EnableTransactionManagement
open class Neo4jConfiguration {

    @Bean
    open fun sessionFactory(): SessionFactory = SessionFactory("demo.neo4j.domain")

    @Bean
    open fun transactionManager(): Neo4jTransactionManager = Neo4jTransactionManager(sessionFactory())
}
