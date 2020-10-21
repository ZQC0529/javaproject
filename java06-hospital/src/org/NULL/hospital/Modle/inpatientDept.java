package org.NULL.hospital.Modle;

public class inpatientDept extends abstractDept {
    String ward;

    public inpatientDept(){}
    @Override
    public String toString() {
        return "inpatientDept:"+'\n'+'\n'+"id:"+this.id+'\n'+"name:"+this.name+'\n'+"inHospital?:"+this.inHospital+'\n'+"description"+this.description+'\n'
                +"ward:"+this.ward+'\n';
    }
}
