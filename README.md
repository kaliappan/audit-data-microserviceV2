# audit-data-microserviceV2
audit data microservice full version

This project gives following features-

1. For Cache service, given an api to GET/retrieve the list projects:

        Request:
        * Method: GET
        * URL: http://localhost:9080/api/projects
        
        Response:
        [
          {
            "project_id": 1,
            "project_name": "INFINITE JAPAN INTEGRATION",
            "created_ts": "2020-03-30T11:33:36.226344"
          },
          {
            "project_id": 2,
            "project_name": "BLAZE NEXTGEN INTEGRATION",
            "created_ts": "2020-03-30T11:35:11.469615"
          },
          {
            "project_id": 3,
            "project_name": "EASI",
            "created_ts": "2020-03-30T11:35:19.660035"
          }
        ]
        
        
1.1. For Cache service, given an api to GET retrieve project information for project by id.        
        Request:
        * Method: GET
        * URL: http://localhost:9080/api/projects/1
        
        Response:
        {
          "project_id": 1,
          "project_name": "INFINITE JAPAN INTEGRATION",
          "created_ts": "2020-03-30T11:33:36.226344"
        }
        
2. For Cache service, given an api to GET/retrieve the list of systems: 
        Request:
        * Method: GET
        * URL: http://localhost:9080/api/systems
        
        Response:
        [
          {
            "system_id": 1,
            "project_id": 1,
            "system_name": "RIL",
            "created_ts": "2020-03-30T11:48:25.317705"
          },
          {
            "system_id": 2,
            "project_id": 1,
            "system_name": "INFINITE",
            "created_ts": "2020-03-30T11:48:25.323226"
          },
          {
            "system_id": 3,
            "project_id": 1,
            "system_name": "AUTOLINE",
            "created_ts": "2020-03-30T11:48:25.331007"
          },
          {
            "system_id": 4,
            "project_id": 1,
            "system_name": "DH",
            "created_ts": "2020-03-30T11:48:25.335146"
          },
          {
            "system_id": 5,
            "project_id": 1,
            "system_name": "IIB",
            "created_ts": "2020-03-30T11:48:25.341473"
          },
          {
            "system_id": 6,
            "project_id": 1,
            "system_name": "ECONTRACT",
            "created_ts": "2020-03-30T11:48:25.346276"
          },
          {
            "system_id": 7,
            "project_id": 1,
            "system_name": "BLAZE",
            "created_ts": "2020-03-30T11:48:25.351369"
          },
          {
            "system_id": 8,
            "project_id": 1,
            "system_name": "NEXT_GEN",
            "created_ts": "2020-03-30T11:48:25.357939"
          },
          {
            "system_id": 9,
            "project_id": 1,
            "system_name": "EASI",
            "created_ts": "2020-03-30T11:48:27.256255"
          }
        ]

2.1. For Cache service, given an api to GET retrieve system information for system by id.        
        Request:
        * Method: GET
        * URL: http://localhost:9080/api/systems/1
        
        Response:
        {
          "system_id": 1,
          "project_id": 1,
          "system_name": "RIL",
          "created_ts": "2020-03-30T11:48:25.317705"
        }

3. For Cache service, given an api to GET retrieve interface information for interface by id.        
        Request:
        * Method: GET
        * URL: http://localhost:9080/api/interfaces/1
        
        Response:
        {
          "interface_id": 1,
          "system_id": 2,
          "interface_name": "DH_INFINITE_ASSET",
          "created_ts": "2020-03-30T11:58:05.12779"
        }
        
4. For Audit service, gives an api to 'save audit message' in Audit Table.

        Request:
        * Method: POST        
        * POST http://localhost:9081/api/audits/
        {
            "interface_id": 5,
            "source_system_id": 4,
            "target_system_id": 2,
            "project_id": 1,
            "source_reference_id": "JP_IIB_INF_DataMapping",
            "status": "Success Response message sent"
        } 
        
        Response:
        {
            "audit_id": 4,
            "interface_id": 5,
            "source_system_id": 4,
            "target_system_id": 2,
            "source_reference_id": "JP_IIB_INF_DataMapping",
            "project_id": 1,
            "created_ts": "2020-03-30T12:57:22.466",
            "status": "Success Response message sent"
        } 
        
apidfsschema=# select * from audit;


audit_id | interface_id | source_system_id | target_system_id | project_id |  source_reference_id  |  created_ts |  updated_ts  | status

----------------------------------------------------------------------------------------------------------------------------------------

        1 |            5 |                4 |                2 |          1 | JP_IIB_INF_DataMapping | 2020-03-30 12:54:20.174+05:30 | 2020-03-30 12:54:20.174+05:30 | Received Input
        2 |            5 |                4 |                2 |          1 | JP_IIB_INF_DataMapping | 2020-03-30 12:56:36.805+05:30 | 2020-03-30 12:56:36.805+05:30 | Request message sent to IIB
        3 |            5 |                4 |                2 |          1 | JP_IIB_INF_DataMapping | 2020-03-30 12:57:01.683+05:30 | 2020-03-30 12:57:01.683+05:30 | Response received from IIB
        4 |            5 |                4 |                2 |          1 | JP_IIB_INF_DataMapping | 2020-03-30 12:57:22.466+05:30 | 2020-03-30 12:57:22.466+05:30 | Success Response message sent        
        

5. For Audit service, gives an api to 'save audit data message' in Audit-data Table.

        Request:
        * Method: POST        
        * POST http://localhost:9081/api/audits/
        {
            "audit_id": 1,
            "source_reference_id": "JP_IIB_INF_DataMapping=INT985-01-3",
            "request_data": "Request data file1",
            "response_data": "ok" 
        }
        Response:
        {
            "audit_data_id": 3,
            "audit_id": 1,
            "source_reference_id": "JP_IIB_INF_DataMapping=INT985-01-3",
            "request_data": "Request data file1",
            "response_data": "ok",
            "created_ts": "2020-03-30T13:07:00.86"
        }
        
        
apidfsschema=# select * from audit_data;


audit_data_id | audit_id |   source_reference_id   |    request_data    | response_data |    created_ts         |          updated_ts

----------------------------------------------------------------------------------------------------------------------------------------


             1 |        1 | JP_IIB_INF_DataMapping=INT985-01   | Request data file1 |               | 2020-03-30 13:05:42.971+05:30 | 2020-03-30 13:05:42.971+05:30
             2 |        1 | JP_IIB_INF_DataMapping=INT985-01-2 | Request data file1 | null          | 2020-03-30 13:06:42.505+05:30 | 2020-03-30 13:06:42.505+05:30
             3 |        1 | JP_IIB_INF_DataMapping=INT985-01-3 | Request data file1 | ok            | 2020-03-30 13:07:00.86+05:30  | 2020-03-30 13:07:00.86+05:30
