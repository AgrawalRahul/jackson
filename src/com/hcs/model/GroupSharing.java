package com.hcs.model;


public class GroupSharing extends SharingType {
    
    private int groupCount;
    
    public GroupSharing(){
        
    }
    
    public GroupSharing(int count){
        groupCount = count;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }
    
    @Override
    public boolean equals(Object arg0) {
        if(arg0 != null && arg0 instanceof GroupSharing){
            return ((GroupSharing)arg0).getGroupCount() == getGroupCount();
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return getGroupCount();
    }

}
