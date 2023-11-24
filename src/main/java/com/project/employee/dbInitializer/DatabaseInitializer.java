package com.project.employee.dbInitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        createUUIDExtension();
        createTables();
        createIndexes();
    }

    private void createUUIDExtension() {
        jdbcTemplate.execute("CREATE EXTENSION IF NOT EXISTS \"uuid-ossp\"");
    }

    private void createTables() {

        // create department table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS department (" +
                "department_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "department_head_id UUID, " +
                "department_name VARCHAR(100), " +
                "total_members INTEGER)");

        // create employee_profile table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employee_profile (" +
                "employee_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "department_id UUID REFERENCES department(department_id) ON DELETE SET NULL, " +
                "designation VARCHAR(100), " +
                "salary NUMERIC(10, 2), " +
                "date_of_joining DATE)");

        // create user_login table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS user_login (" +
                "login_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "employee_id UUID REFERENCES employee_profile(employee_id) ON DELETE CASCADE, " +
                "user_name VARCHAR(50) NOT NULL, " +
                "password VARCHAR(100) NOT NULL, " +
                "role VARCHAR(50) NOT NULL)");

        // create employee_info table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employee_info (" +
                "info_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "employee_id UUID REFERENCES employee_profile(employee_id) ON DELETE CASCADE, " +
                "name VARCHAR(100) NOT NULL, " +
                "age INTEGER, " +
                "dob DATE, " +
                "nationality VARCHAR(50), " +
                "gender VARCHAR(10), " +
                "marital_status VARCHAR(20), " +
                "recent_education_qualification VARCHAR(100), " +
                "address TEXT, " +
                "phone_no VARCHAR(15), " +
                "personal_email VARCHAR(100), " +
                "office_email VARCHAR(100))");

        // create employee_leave table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employee_leave (" +
                "leave_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "employee_id UUID REFERENCES employee_profile(employee_id) ON DELETE CASCADE, " +
                "start_date DATE, " +
                "end_date DATE, " +
                "remaining_al INTEGER, " +
                "remaining_el INTEGER, " +
                "remaining_ml INTEGER, " +
                "total_leave_balance INTEGER, " +
                "total_unpaid_leave INTEGER)");

        // create leave_application table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS leave_application (" +
                "application_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "leave_id UUID REFERENCES employee_leave(leave_id) ON DELETE CASCADE, " +
                "leave_type VARCHAR(50), " +
                "description TEXT, " +
                "start_date DATE, " +
                "end_date DATE, " +
                "status VARCHAR(20), " +
                "approver_id UUID REFERENCES employee_profile(employee_id) ON DELETE SET NULL, " +
                "approval_date DATE)");

        // create monthly_attendance table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS monthly_attendance (" +
                "monthly_attendance_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "employee_id UUID REFERENCES employee_profile(employee_id) ON DELETE CASCADE, " +
                "month DATE, " +
                "total_working_day INTEGER, " +
                "total_attendance INTEGER, " +
                "total_paid_leave INTEGER, " +
                "total_unpaid_leave INTEGER)");

        // create daily_attendance table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS daily_attendance (" +
                "daily_attendance_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "monthly_attendance_id UUID REFERENCES monthly_attendance(monthly_attendance_id) ON DELETE CASCADE, " +
                "check_in_time TIMESTAMP, " +
                "check_out_time TIMESTAMP, " +
                "date DATE)");

        // create monthly_salary table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS monthly_salary (" +
                "monthly_salary_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), " +
                "employee_id UUID REFERENCES employee_profile(employee_id) ON DELETE CASCADE, " +
                "month DATE, " +
                "salary_amount NUMERIC(10, 2), " +
                "bonus NUMERIC(10, 2), " +
                "bonus_remark TEXT, " +
                "deductions NUMERIC(10, 2), " +
                "deduction_remark TEXT, " +
                "pay_date DATE)");
    }


    private void createIndexes() {
        jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_employee_leave_employee_id ON employee_leave(employee_id)");
        jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_leave_application_leave_id ON leave_application(leave_id)");
        jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_leave_application_approver_id ON leave_application(approver_id)");
        jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_monthly_attendance_employee_id ON monthly_attendance(employee_id)");
        jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_daily_attendance_monthly_attendance_id ON daily_attendance(monthly_attendance_id)");
        jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_monthly_salary_employee_id ON monthly_salary(employee_id)");
    }
}