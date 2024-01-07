package com.tejas.xml.test;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltTestEVC {

	public static void main(String[] args) throws Exception {
		String str = "<TejOSS><FPTemplate>   <ProvisionOrder>1</ProvisionOrder>   <ProvisionAction>9</ProvisionAction>   <NodeIndex>0-0-99</NodeIndex>   <Description>NMS-Default-Service1-1-1-3-3</Description></FPTemplate><EVC>   <ProvisionOrder>0</ProvisionOrder>   <ProvisionAction>9</ProvisionAction>   <NodeIndex>0-0-99</NodeIndex>   <UserLabel>test</UserLabel>   <Owner>test</Owner>   <LCTName>Default-Service1</LCTName>   <NMSInfo>GPON_SINGLETON;GS-1;TJ5500</NMSInfo>   <AdminState>2</AdminState>   <CI>0</CI>   <CustomerName>11</CustomerName>   <EVCForwardingType>1</EVCForwardingType>   <EVCName>NMS-Default-Service1-1</EVCName>   <EVCServiceType>2</EVCServiceType>   <FDBLimiting>1</FDBLimiting>   <SI>0</SI>   <SN>99</SN>   <TrailIdentifier>10000902</TrailIdentifier></EVC><FlowPoint>   <ProvisionOrder>3</ProvisionOrder>   <ProvisionAction>9</ProvisionAction>   <NodeIndex>0-0-99-$0</NodeIndex>   <AdminState>2</AdminState>   <DHCPSnoopingEnable>1</DHCPSnoopingEnable>   <DHCPv6SnoopingEnable>1</DHCPv6SnoopingEnable>   <EgressTPID />   <FPTemplate>$1</FPTemplate>   <FPTemplateID>$1</FPTemplateID>   <FlowPointMode>1</FlowPointMode>   <FlowPointType>1</FlowPointType>   <IPAntiSpoofFilter>1</IPAntiSpoofFilter>   <IPAntiSpoofing>1</IPAntiSpoofing>   <IfIndex>12288</IfIndex>   <IngressColourSource>1</IngressColourSource>   <IngressPrioritySource>1</IngressPrioritySource>   <MacFFEnable>1</MacFFEnable>   <PPPoESnoopingEnable>1</PPPoESnoopingEnable>   <PPPoETrusted>1</PPPoETrusted>   <TrustIngressColour>1</TrustIngressColour>   <TrustIngressPriority>1</TrustIngressPriority>   <Trusted>2</Trusted></FlowPoint><CVLANFlowPointClassRule>   <ProvisionOrder>2</ProvisionOrder>   <ProvisionAction>9</ProvisionAction>   <NodeIndex>0-0-99-$1</NodeIndex>   <MatchCVLANIdHigh>21</MatchCVLANIdHigh>   <MatchCVLANIdLow>21</MatchCVLANIdLow></CVLANFlowPointClassRule></TejOSS>";

		StringWriter out = new StringWriter();

		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer(new StreamSource(XsltTestEVC.class.getResourceAsStream("provisioner.xslt")));
		transformer.setParameter("IPAddress", "10.124.1.1");
		transformer.setParameter("SessionId", "3");

		transformer.transform(new StreamSource(new StringReader(str.toString())), new StreamResult(out));
		
		System.out.println(out.toString());
	}

}
