package api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



import poe.user.Track;
import poe.user.TrackDao;
import poe.user.User;

@Path("track")
public class UserTrackService {
	
	
		
		@EJB
	TrackDao trackDao;
		
		
		
		 @GET
		    @Produces("application/json")
		    @Path("{id}")
		    public TrackTo show(@PathParam("id") Long trackId) {
		        Track track = trackDao.getTrackById(trackId);
		        TrackTo trackTo = TrackTo.buildFrom(track);
		        return trackTo;
		    }

		    @POST
		    @Path("/{tite}/{artiste}")
		    public Response add(@PathParam("title") String titre, @PathParam("artiste") String artiste, @Context UriInfo uriInfo) {
		        Track track = new Track();
		        track.setTitre(titre);
		        track.setArtiste(artiste);
		        Long trackId = trackDao.addTrackDao(track);
		        return Response.created(uriInfo.getBaseUriBuilder().path(UserTrackService.class).path(Long.toString(trackId)).build()).build();
		    }

		    @POST
		    @Consumes(MediaType.APPLICATION_JSON)
		    public Response addJson(Track track, @Context UriInfo uriInfo) {
		        Long trackId = trackDao.addTrackDao(track);
		        return Response.created(uriInfo.getBaseUriBuilder().path(UserTrackService.class).path(Long.toString(trackId)).build()).build();
		    }

		    @DELETE
		    @Path("{id}")
		    public void delete(@PathParam("id") Long trackId) {
		        trackDao.delete(trackId);
		    }

		    @GET
		    public Collection<Track> list() {
		        return trackDao.getTracksListDao();
		    }
}
