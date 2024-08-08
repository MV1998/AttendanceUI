package com.mohit.jultestforandroid.attendance_feature.database

object LocalDB {

    val reason = """
        {
        "errorCode":0,
        "errorMessage":"",
        "AttendanceAbsentReasonsList":[
        {
        "id":"-1",
        "absentReason":"Select Reason"
        },
        {
        "id":"1",
        "absentReason":"Sick Leave"
        },
        {
        "id":"2",
        "absentReason":"Vacation"
        },
        {
        "id":"3",
        "absentReason":"Personal Leave"
        },
        {
        "id":"4",
        "absentReason":"Family Emergency"
        },
        {
        "id":"5",
        "absentReason":"Bereavement Leave"
        },
        {
        "id":"6",
        "absentReason":"Public Holiday"
        }
        ]
        }
    """.trimIndent()

    val jsonData = """
        {
        "centerId": "123",
        "centerName": "Center A",
        "errorCode": null,"errorMessage": null,
        "groups": [
        {
        "customers": [
        {
        "customerId": "C101",
        "customerName": "John Doe",
        "lans": [],
        "isPresent": null,
        "isClick": null,
        "reason": null
        },

        {
        "customerId": "C102",
        "customerName": "Jane Smith",
        "lans": [],
        "isPresent": null,
        "isClick": "no",
        "reason": null
        },
        {
        "customerId": "C103",
        "customerName": "David Lee",
        "lans": [],
        "isPresent": null,
        "isClick": "no",
        "reason": null
        }],
        "groupDue": 500,
        "groupId": "G1",
        "groupName": "Group Alpha",
        "noOfCustomers": 3,
        "noOfLans": 0
        },
        {
        "customers": [
        {
        "customerId": "C201",
        "customerName": "Alice Brown",
        "lans": [],
        "isPresent": null,
        "isClick": null,
        "reason": null
        },
        {
        "customerId": "C202",
        "customerName": "Bob Wilson",
        "lans": [],
        "isPresent": null,
        "isClick": "no",
        "reason": null
        }
        ],
        "groupDue": 1200,
        "groupId": "G2",
        "groupName": "Group Beta",
        "noOfCustomers": 2,
        "noOfLans": 0
        },
        {
        "customers": [
        {
        "customerId": "C301",
        "customerName":"Eva Green",
        "lans": [],
        "isPresent": null,
        "isClick": null,
        "reason": null
        },

        {
        "customerId": "C302",
        "customerName": "Frank White",
        "lans": [],
        "isPresent": null,
        "isClick": "no",
        "reason": null
        },
        {
        "customerId": "C303",
        "customerName": "Grace Black",
        "lans": [],
        "isPresent": null,
        "isClick": "no",
        "reason": null
        }
        ],
        "groupDue": 800,
        "groupId": "G3",
        "groupName": "Group Gamma",
        "noOfCustomers": 3,
        "noOfLans": 0
        }
        ],
        "lans": [],
        "nextMeetingDate": "2024-08-15"
        }
    """.trimIndent()
}