package me.destinyofyeet.TeamsSimplifiedDynmapExtension.chunkCalculation;

public class ChunkRange {
    private Chunk2Block chunk1;
    private Chunk2Block chunk2;

    public ChunkRange(Chunk2Block chunk1, Chunk2Block chunk2){
        this.chunk1 = chunk1;
        this.chunk2 = chunk2;
    }

    public int getChunkXStart(){
        return chunk1.getChunkXStart();
    }

    public int getChunkXEnd(){
        return chunk2.getChunkXEnd();
    }

    public int getChunkZStart(){
        return chunk1.getChunkZStart();
    }

    public int getChunkZEnd(){
        return chunk2.getChunkZEnd();
    }
}
