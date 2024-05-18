package com.ftn.sbnz.model;

import org.kie.api.definition.type.Position;

public class ClassNameBackward {
    @Position(0)
    public String child;
    @Position(1)
    public String parent;
    public String getChild() {
        return child;
    }
    public void setChild(String child) {
        this.child = child;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    
    public ClassNameBackward(String child, String parent) {
        this.child = child;
        this.parent = parent;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((child == null) ? 0 : child.hashCode());
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClassNameBackward other = (ClassNameBackward) obj;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        if (parent == null) {
            if (other.parent != null)
                return false;
        } else if (!parent.equals(other.parent))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ClassNameBackward [child=" + child + ", parent=" + parent + "]";
    }
    
}
