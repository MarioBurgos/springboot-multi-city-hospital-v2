# Multi-city Hospital

## Springboot REST API

_______________________________


### _Did you use the same type of route to update patient information and to update an employee department?_

Nope, to update a patient it is using the route:      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; _http://..../patients/{id}_

...and to update an employee department, this one:       
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_http://..../doctors/{id}/department_

and it happens to be like that because update patient's verb is PUT and update employee's verb is PATCH.


### _Why did you choose the strategy that you chose?_
  
RESTful Resources Naming Convention help us, developers, to intuitively know what to look for and where to find it.  


### _What are the pros and cons of the strategies you chose for creating these routes?_

The main benefit of using the naming convention is that it helps to read or predict what source will get from an endpoint.  On the other hand, if a developer is not familiar with the naming convention, using it can be quite confusing because in some cases the mapped routes are exactly the same.  

```
        @GetMapping("/doctors")                                @PostMapping("/doctors")
        public List<Doctor> findAll() {                        @ResponseStatus(HttpStatus.CREATED)
            return doctorService.findAll();                    public void add(@RequestBody @Valid Doctor doctor) {
        }                                                      doctorService.add(doctor);
```

The controller in this application maps the same url but they address to different services.  This can be confusing for frontend developers since they are used to descriptive urls on the websites.

So, you'd better be familiar with RESTful if you want to work in big companies.




### _What are the tradeoffs between PUT and PATCH?_

PUT allows to update the entire table on DB.  PATCH a specific resource.  

Imagine a streaming service or a huge online shopping website.  They handle thousands, millions of resources here and there every second.  Every bit counts in terms of efficiency.  Now, imagine that a user of one of these platforms wants to change the profile name on the account.  What would be more efficient? Replace all the profile information with a new one that is identical except for the profile name or __patch__ only what is needed?  Obviously, PATCH will be the winner here.

PUT instead, will be more efficient at the point that the whole pack of resources we need to change bypass other requirements.  

Pure DTO-based services add a remarkable level of extra complexity and work to do, sometimes painful if we are figuring or maintaining a project with hundreds of entity objects and even more use cases.