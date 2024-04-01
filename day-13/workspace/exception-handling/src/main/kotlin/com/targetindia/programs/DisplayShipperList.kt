package com.targetindia.programs

import com.targetindia.exceptions.RepositoryException
import java.sql.DriverManager
import java.sql.SQLException

fun main() {
    val url = "jdbc:h2:tcp://localhost/~/northwind"
    val user = "root"
    val password = "Welcome#123"
    val sql = "select * from shippers"

    try {
        DriverManager.getConnection(url, user, password).use {
            it.prepareStatement(sql).use {
                it.executeQuery().use {
                    while (it.next()) {
                        val companyName = it.getString("company_name")
                        val phone = it.getString("phone")
                        println("$companyName --> $phone")
                    }
                }
            }
        }
    } catch (e: SQLException) {
        throw RepositoryException(e)
    }
}