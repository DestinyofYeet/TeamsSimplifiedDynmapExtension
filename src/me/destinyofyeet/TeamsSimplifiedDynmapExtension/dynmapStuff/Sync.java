package me.destinyofyeet.TeamsSimplifiedDynmapExtension.dynmapStuff;

import me.destinyofyeet.TeamsSimplifiedDynmapExtension.chunkCalculation.Chunk2Block;
import me.destinyofyeet.TeamsSimplifiedDynmapExtension.main.Main;
import me.destinyofyeet.TeamsSimplifiedDynmapExtension.utils.ColorMapping;
import org.bukkit.configuration.Configuration;
import org.dynmap.markers.AreaMarker;
import org.dynmap.markers.MarkerSet;

import java.util.List;

public class Sync{

    public static void doSync() {
        MarkerSet markerSet = Main.getDynmapAPI().getMarkerAPI().getMarkerSet("claimed_chunks");

        if (markerSet != null){
            markerSet.deleteMarkerSet();
        }

        markerSet = Main.getDynmapAPI().getMarkerAPI().createMarkerSet("claimed_chunks", "Claimed Chunks", Main.getDynmapAPI().getMarkerAPI().getMarkerIcons(), false);


        Configuration config = Main.getTeamsSimplified().getConfig();

        List<String> playerTeams = config.getStringList("Teams.AllTeams");

        for (String teamName: playerTeams){
            String teamTag = config.getString("Teams.PlayerTeams." + teamName + ".tag");
            String teamColor = config.getString("Teams.PlayerTeams." + teamName + ".color").replace("§", "&");

            List<Integer> allChunks = config.getIntegerList("Chunks.TeamChunks." + teamName + ".allChunks");

            for(int currentChunk: allChunks){
                String chunkConfig = "Chunks.TeamChunks." + teamName + "." + currentChunk;
                String worldName = config.getString(chunkConfig + ".World");
                int chunkX = config.getInt(chunkConfig + ".X");
                int chunkZ = config.getInt(chunkConfig + ".Z");

                Chunk2Block convert = new Chunk2Block(chunkX, chunkZ);

                AreaMarker marker = markerSet.createAreaMarker("claimed_chunk_" + teamName + "_" + currentChunk, "Chunk claimed by " + teamTag,
                        true, worldName, new double[]{convert.getChunkXStart(), convert.getChunkXEnd()}, new double[]{convert.getChunkZStart(), convert.getChunkZEnd()}, false);




                marker.setFillStyle(0.25, ColorMapping.getColor(teamColor));
            }
        }

        Main.getPlugin().getLogger().info("Re-drew claimed chunks");
    }
}
