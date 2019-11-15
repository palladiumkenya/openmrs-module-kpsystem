UPDATE  openmrs.global_property SET 
 property_value = '<org.openmrs.layout.web.address.AddressTemplate>\r\n        <nameMappings class=\"properties\">\r\n            <property name=\"address1\" value=\"Postal Address\"/>\r\n           \r\n            <property name=\"stateProvince\" value=\"Sub County\"/>\r\n            <property name=\"address6\" value=\"Location\"/>\r\n            <property name=\"address5\" value=\"Sub Location\"/>\r\n            <property name=\"cityVillage\" value=\"Village\"/>\r\n            <property name=\"countyDistrict\" value=\"County\"/>\r\n        </nameMappings>\r\n        <sizeMappings class=\"properties\">\r\n            <property name=\"address2\" value=\"55\"/>\r\n            <property name=\"address1\" value=\"55\"/>\r\n            <property name=\"stateProvince\" value=\"24\"/>\r\n            <property name=\"cityVillage\" value=\"24\"/>\r\n            <property name=\"countyDistrict\" value=\"24\"/>\r\n        </sizeMappings>\r\n        \r\n        <lineByLineFormat>\r\n            <string>address1</string>\r\n			<string>countyDistrict stateProvince</string>\r\n			<string>address6 address5 </string>\r\n			<string>cityVillage</string>\r\n          \r\n        </lineByLineFormat>\r\n    </org.openmrs.layout.web.address.AddressTemplate>',
 description =  'XML description of address formats', 
 uuid= '8398d42c-00ed-4176-959f-17aa9e5cbc53',
 datatype= NULL, 
 datatype_config=NULL, 
 preferred_handler=NULL, 
 handler_config=   NULL
WHERE property= 'layout.address.format'

