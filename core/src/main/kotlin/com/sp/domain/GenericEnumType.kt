package com.sp.domain

import com.sp.domain.enums.*
import org.hibernate.*
import org.hibernate.engine.spi.*
import org.hibernate.usertype.*
import java.io.Serializable
import java.sql.*
import java.util.*

/**
 * @author YeonKyung Kim
 */
class GenericEnumType : DynamicParameterizedType, UserType {
    companion object {
        const val NAME = "com.sp.domain.GenericEnumType"
    }

    private lateinit var enumClass: Class<out GenericEnumType>

    @Suppress("UNCHECKED_CAST")
    override fun setParameterValues(parameters: Properties) {
        val params = parameters[DynamicParameterizedType.PARAMETER_TYPE] as DynamicParameterizedType.ParameterType
        enumClass = params.returnedClass as Class<out GenericEnumType>
    }

    override fun sqlTypes(): IntArray {
        return intArrayOf(Types.VARCHAR)
    }

    override fun returnedClass(): Class<*> {
        return enumClass
    }

    @Throws(HibernateException::class)
    override fun equals(x: Any?, y: Any?): Boolean {
        return x == y
    }

    @Throws(HibernateException::class)
    override fun hashCode(x: Any?): Int {
        return x?.hashCode() ?: 0
    }

    @Throws(HibernateException::class, SQLException::class)
    override fun nullSafeGet(
        rs: ResultSet, names: Array<String>, session: SharedSessionContractImplementor,
        owner: Any?
    ): Any? {
        val value = rs.getString(names[0])
        if (rs.wasNull()) {
            return null
        }
        for (v in returnedClass().enumConstants) {
            if (v is GenericEnum && v.value == value) {
                return v
            }
        }
        return null
    }

    @Throws(HibernateException::class, SQLException::class)
    override fun nullSafeSet(
        st: PreparedStatement, value: Any?, index: Int,
        session: SharedSessionContractImplementor
    ) {
        if (value == null) {
            st.setNull(index, Types.VARCHAR)
        } else {
            st.setString(index, (value as GenericEnum).value)
        }
    }

    @Throws(HibernateException::class)
    override fun deepCopy(value: Any?): Any? {
        return value
    }

    override fun isMutable(): Boolean {
        return false
    }

    @Throws(HibernateException::class)
    override fun disassemble(value: Any): Serializable? {
        return null
    }

    @Throws(HibernateException::class)
    override fun assemble(cached: Serializable, owner: Any): Any {
        return cached
    }

    @Throws(HibernateException::class)
    override fun replace(original: Any?, target: Any?, owner: Any?): Any? {
        return original
    }
}
