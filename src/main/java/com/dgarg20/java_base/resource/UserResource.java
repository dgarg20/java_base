package com.dgarg20.java_base.resource;

import com.dgarg20.java_base.exceptions.TempException;
import com.dgarg20.java_base.requests.AddUsersToGroupRequest;
import com.dgarg20.java_base.service.GroupService;
import com.google.inject.Inject;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */

@Path("/v1/group")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class UserResource {
    private GroupService  groupService;
    @Inject
    public UserResource(GroupService  groupService) {
        this.groupService = groupService;
    }

    @POST
    @Path("/{name}")
    public Response createGroup( @HeaderParam("X-CURRENT-USER")String currentUser, @PathParam("name")String groupName) {
        try {
            groupService.createGroup(groupName, currentUser);
            return Response.ok().build();
        }
        catch (TempException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex).build();
        }
        catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Path("/{id}/users")
    @POST
    public Response addUsersToGroup(@PathParam("id") int groupId,
                                    @HeaderParam("X-CURRENT-USER") String currentUser,
                                    AddUsersToGroupRequest addUsersToGroupRequest) {
        try {
            groupService.addUser(addUsersToGroupRequest.getUserList(), currentUser, groupId);
            return Response.ok().build();
        }
        catch (TempException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex).build();
        }
        catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
