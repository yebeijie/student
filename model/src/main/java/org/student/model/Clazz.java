package org.student.model;

import org.aten.db.ann.MyTable;
import org.aten.db.ann.TableId;

@MyTable("PerClass")
public class Clazz {

    @TableId
    private int classId;

    private String className;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
