package com.dgarg20.dropwizardcrud.controller;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.dgarg20.dropwizardcrud.services.CrudService;
import com.google.inject.Inject;
import io.swagger.annotations.Api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import sun.nio.ch.IOUtil;



//import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Api("Attribute Level APIs")
//@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/dropwizardcrud")
@Produces(MediaType.APPLICATION_JSON)
//@RequiredArgsConstructor(onConstructor = @__(@Inject))
@AllArgsConstructor(onConstructor = @__(@Inject))
@Timed
@ExceptionMetered

//@Inject
public class CrudResources {
    private final CrudService crudService;

//    @Inject
//    public CrudResources(CrudService crudService){
//        this.crudService = crudService;
//    }


    @GET
    public Response getAll(){

        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") final int id){

        return Response.ok().build();
    }

    @POST
    public Response create(){
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final int id){
        return Response.ok().build();
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") final int id){
        return Response.ok().build();
    }


    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @GET
    @Path("download/single")
    public Response downloadOne(){
        return Response.ok().build();
    }

    @Produces("application/zip")
    @GET
    @Path("download/zip")
    public Response downloadZip(){

        try {
            File zipFile = new File("t.zip");
            final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
            for(File f: downloadAll(2)){
                zos.putNextEntry(new ZipEntry(f.getName()));

                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));


                FileInputStream fis = new FileInputStream(f);
                byte []bytes = new byte[(int) f.length()];
                fis.read(bytes);
                zos.write(bytes, 0, (int)f.length());


                int data = 0;
                while((data = bis.read())!= -1){
                    zos.write(data);
                }
                bis.close();
                zos.closeEntry();

            }
            zos.close();

            return Response
                    .ok(zipFile)
                    .header("Content-Disposition", "attachment; filename=download.zip")
                    .header("Content-Transfer-Encoding", "binary")
                    .build();
        }
        catch (FileNotFoundException ex){
            throw new WebApplicationException("file not downloaded", Response.Status.BAD_REQUEST);
        }
        catch (IOException ex){
            throw new WebApplicationException("file not downloaded", Response.Status.BAD_REQUEST);
        }

    }
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("download/zipAll")
    public Response downloadZip2() {
        StreamingOutput stream = new StreamingOutput(){

            public void write(OutputStream output) throws IOException, WebApplicationException {
                final ZipOutputStream zos = new ZipOutputStream(output);
                for(File f: downloadAll(2)){
                    zos.putNextEntry(new ZipEntry(f.getName()));
                    zos.write(f.getName().getBytes());
                    zos.close();
                }
            }
        };
        Response.ResponseBuilder response =
                Response.ok(stream)
                .header("Content-Disposition", "attachment; filename=download.zip")
                .header("Content-Transfer-Encoding", "binary");

        return response.build();

    }



    private File[] downloadAll(int divisiblity){
        final File file = new File("temp.csv");
        StreamingOutput so = new StreamingOutput() {
            public void write(OutputStream output) throws IOException, WebApplicationException {
                output.write(IOUtil.);

            }
        }
        return ;
    }
}
