<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">
<xsl:template match="/">
    <HTML>
     <BODY>
       <CENTER>
       <TABLE BORDER="1">
           <TR>
                <TD>姓名</TD>
                <TD>年龄</TD>
                <TD>电话</TD>
           </TR>
      <xsl:for-each select="persons/person">
           <TR>
                <TD><xsl:value-of select="name"/></TD>
                <TD><xsl:value-of select="age"/></TD>
                <TD><xsl:value-of select="tel"/></TD>
           </TR>
      </xsl:for-each>
       </TABLE>
       </CENTER>
     </BODY>
    </HTML>
</xsl:template>
</xsl:stylesheet>
