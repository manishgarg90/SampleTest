<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:param name="SessionId"/>
    <xsl:param name="IPAddress"/>

    <xsl:template match="/TejOSS">
        <TejOSS>
        <xsl:for-each select="child::*">
            <Request>
                <Node>
                    <xsl:value-of select="$IPAddress"/>
                </Node>
                <SessionId>
                    <xsl:value-of select="$SessionId"/>
                </SessionId>
                <Action><xsl:value-of select="./ProvisionAction"/></Action>
                <NodeObject>
                    <ObjectType>
                        <xsl:value-of select="name()"/>
                    </ObjectType>
                    <ObjectId>
                        <xsl:value-of select="name()"/>
                    </ObjectId>
                    <Order>
                        <xsl:value-of select="./ProvisionOrder"/>
                    </Order>
                    <NodeIndex>
                        <xsl:value-of select="./NodeIndex"/>
                    </NodeIndex>
                    <xsl:if test="name()='EVC'">
                        <Attribute>
                            <name>
                               <xsl:value-of select="name(./UserLabel)"/>
                            </name>
                            <value>
                                <xsl:value-of select="./UserLabel"/>
                            </value>
                        </Attribute>
                    </xsl:if> 
                    <xsl:for-each select="child::*[name()!='NodeIndex' and name()!='ProvisionAction' and name()!='ProvisionOrder' and name()!='Owner' and name()!= 'UserLabel']">
                        <Attribute>
                            <name>
                                <xsl:value-of select="name()"/>
                            </name>
                            <value>
                                <xsl:value-of select="."/>
                            </value>
                        </Attribute>
                    </xsl:for-each>
                </NodeObject>
            </Request>
        </xsl:for-each>
        </TejOSS>
    </xsl:template>
</xsl:stylesheet>
