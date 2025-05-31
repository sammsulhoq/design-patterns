package structural.facade;

// The Facade
public class MediaPlayerFacade {
    private final FileLoader loader = new FileLoader();
    private final AudioDecoder audio = new AudioDecoder();
    private final VideoDecoder video = new VideoDecoder();
    private final BufferManager buffer = new BufferManager();
    private final Renderer renderer = new Renderer();

    public void play(String filename) {
        loader.loadFile(filename);
        audio.decodeAudio(filename);
        video.decodeVideo(filename);
        buffer.fillBuffer();
        renderer.renderFrame();
        System.out.println("Playback started.");
    }
}
