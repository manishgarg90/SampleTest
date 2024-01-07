SELECT 
  * 
from 
  (
    (
      SELECT 
        TejasKey as TKey, 
        LCTName, 
        Owner, 
        NMSInfo as UserLabel, 
        R_IP, 
        L_CI, 
        L_SI, 
        L_PN, 
        R_CI, 
        R_SI, 
        R_PN, 
        L_AUG, 
        L_AU, 
        R_AUG, 
        R_AU, 
        ConduitList, 
        NULL AS SRLG, 
        NULL AS LocalIfIndex, 
        NULL AS RemoteIfIndex, 
        TrunkMedium, 
        Capacity, 
        Offline, 
        NULL as AEndPortType, 
        NULL as LocalFPCRPrioritySource, 
        NULL as AEndCapacity, 
        NULL as ZEndPortType, 
        NULL as RemoteFPCRPrioritySource, 
        NULL as ZEndCapacity, 
        NULL as LocalSwitchNumber, 
        NULL as RemoteSwitchNumber, 
        NULL as SLBaseValue, 
        NULL as SLDeltaValue, 
        NULL as LastSpanLoss, 
        NULL as AGCLastSpanLoss, 
        NULL as AGCRegThreshold, 
        NULL as NetSpanLoss 
      FROM 
        Trunk
    ) 
    union all 
      (
        SELECT 
          TejasKey as TKey, 
          LCTName, 
          Owner, 
          NMSInfo as UserLabel, 
          R_IP, 
          L_CI, 
          L_SI, 
          L_PN, 
          R_CI, 
          R_SI, 
          R_PN, 
          L_AUG, 
          L_AU, 
          R_AUG, 
          R_AU, 
          ConduitList, 
          NULL AS SRLG, 
          NULL AS LocalIfIndex, 
          NULL AS RemoteIfIndex, 
          0 as TrunkMedium, 
          Capacity, 
          Offline, 
          NULL as AEndPortType, 
          NULL as LocalFPCRPrioritySource, 
          NULL as AEndCapacity, 
          NULL as ZEndPortType, 
          NULL as RemoteFPCRPrioritySource, 
          NULL as ZEndCapacity, 
          NULL as LocalSwitchNumber, 
          NULL as RemoteSwitchNumber, 
          SLBaseValue, 
          SLDeltaValue, 
          LastSpanLoss, 
          AGCLastSpanLoss, 
          AGCRegThreshold, 
          NetSpanLoss 
        FROM 
          AmplifierTrunk
      ) 
    union all 
      (
        select 
          PacketTrunk.TejasKey as TKey, 
          LCTName, 
          Owner, 
          NMSInfo as UserLabel, 
          RemoteIPAddress AS R_IP, 
          PacketTrunk.CI as L_CI, 
          PacketTrunk.SI as L_SI, 
          PacketTrunk.PN as L_PN, 
          R_CI, 
          R_SI, 
          R_PN, 
          0 AS L_AUG, 
          0 AS L_AU, 
          0 AS R_AUG, 
          0 AS R_AU, 
          NULL as ConduitList, 
          SRLG AS SRLG, 
          LocalIfIndex, 
          RemoteIfIndex, 
          0 as TrunkMedium, 
          Capacity, 
          Offline, 
          P1.PortType AS AEndPortType, 
          P1.FPCRPrioritySource AS LocalFPCRPrioritySource, 
          substring_index(P1.NodeIndex, '-', 1) AS AEndCapacity, 
          P2.PortType AS ZEndPortType, 
          P2.FPCRPrioritySource AS RemoteFPCRPrioritySource, 
          substring_index(P2.NodeIndex, '-', 1) AS ZEndCapacity, 
          LocalSwitchNumber, 
          RemoteSwitchNumber, 
          NULL as SLBaseValue, 
          NULL as SLDeltaValue, 
          NULL as LastSpanLoss, 
          NULL as AGCLastSpanLoss, 
          NULL as AGCRegThreshold, 
          NULL as NetSpanLoss 
        from 
          PacketTrunk 
          inner join (
            select 
              Port.NodeIndex, 
              Port.IPAddress, 
              PortParams.PortType, 
              PortParams.FPCRPrioritySource, 
              Port.CI, 
              Port.SI, 
              Port.PN, 
              Port.TejasKey, 
              Port.ifIndex 
            from 
              Port 
              inner join (
                select 
                  L2InterfaceParams.TejasKey, 
                  L2InterfaceParams.IPAddress, 
                  L2InterfaceParams.CI, 
                  L2InterfaceParams.SI, 
                  L2InterfaceParams.PN, 
                  L2InterfaceParams.PortType, 
                  L2InterfaceParams.FPCRPrioritySource 
                from 
                  L2InterfaceParams 
                where 
                  IPAddress = "2001:0db8:0000:0000:3304:a117:dba1:0d99" 
                UNION ALL 
                select 
                  SwitchPortParams.TejasKey, 
                  SwitchPortParams.IPAddress, 
                  SwitchPortParams.CI, 
                  SwitchPortParams.SI, 
                  SwitchPortParams.PN, 
                  SwitchPortParams.NetworkPortType, 
                  NULL AS FPCRPrioritySource 
                from 
                  SwitchPortParams
              ) PortParams on PortParams.IPAddress = Port.IPAddress 
              AND Port.CI = PortParams.CI 
              AND Port.SI = PortParams.SI 
              AND Port.PN = PortParams.PN 
            where 
              Port.IPAddress = "2001:0db8:0000:0000:3304:a117:dba1:0d99" 
              and Port.DbSourceTable = "Port_Eth" 
              or Port.DbSourceTable = "ChannelBondingGroup" 
              or Port.DbSourceTable = "LAGPort"
          ) P1 on (
            (
              P1.CI = PacketTrunk.CI 
              and P1.SI = PacketTrunk.SI 
              and P1.PN = PacketTrunk.PN
            ) 
            or P1.ifIndex = LocalIfIndex
          ) 
          and P1.IPAddress = PacketTrunk.LocalIPAddress 
          left join (
            select 
              Port.NodeIndex, 
              Port.IPAddress, 
              PortParams.PortType, 
              PortParams.FPCRPrioritySource, 
              Port.CI, 
              Port.SI, 
              Port.PN, 
              Port.TejasKey, 
              Port.ifIndex 
            from 
              Port 
              inner join (
                select 
                  L2InterfaceParams.TejasKey, 
                  L2InterfaceParams.IPAddress, 
                  L2InterfaceParams.CI, 
                  L2InterfaceParams.SI, 
                  L2InterfaceParams.PN, 
                  L2InterfaceParams.PortType, 
                  L2InterfaceParams.FPCRPrioritySource 
                from 
                  L2InterfaceParams 
                UNION ALL 
                select 
                  SwitchPortParams.TejasKey, 
                  SwitchPortParams.IPAddress, 
                  SwitchPortParams.CI, 
                  SwitchPortParams.SI, 
                  SwitchPortParams.PN, 
                  SwitchPortParams.NetworkPortType, 
                  NULL AS FPCRPrioritySource 
                from 
                  SwitchPortParams
              ) PortParams on PortParams.IPAddress = Port.IPAddress 
              AND Port.CI = PortParams.CI 
              AND Port.SI = PortParams.SI 
              AND Port.PN = PortParams.PN 
            where 
              Port.IPAddress = "2001:0db8:0000:0000:3304:a117:dba1:0d99" 
              and Port.DbSourceTable = "Port_Eth" 
              or Port.DbSourceTable = "ChannelBondingGroup" 
              or Port.DbSourceTable = "LAGPort"
          ) P2 on (
            (
              P2.CI = PacketTrunk.R_CI 
              and P2.SI = PacketTrunk.R_SI 
              and P2.PN = PacketTrunk.R_PN
            ) 
            or P2.ifIndex = RemoteIfIndex
          ) 
          and P2.IPAddress = PacketTrunk.RemoteIPAddress
      )
  ) AllTrunks 
WHERE 
  TKey LIKE CONCAT(
    "TOR.1.PhysicalLayer.1.PhysicalNode.2001:0db8:0000:0000:3304:a117:dba1:0d99.", 
    '%'
  ) 
  AND R_AU = 0 
  and R_AUG = 0;
