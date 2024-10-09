package com.fis.bnk.onboarding.security;

import com.fis.bnk.onboarding.entity.Department;
import com.fis.bnk.onboarding.entity.User;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "HR manager's departments and users", code = HRManagerSDepartmentsAndUsersRole.CODE)
public interface HRManagerSDepartmentsAndUsersRole {
    String CODE = "hr-manager-r1";


    @JpqlRowLevelPolicy(entityClass = Department.class, where = "{E}.hrManager.id = :current_user_id")
    void department();

    @JpqlRowLevelPolicy(entityClass = User.class, where = "{E}.department.hrManager.id = :current_user_id")
    void user();
}