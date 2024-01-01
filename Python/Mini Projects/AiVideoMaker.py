from gtts import gTTS
from moviepy.editor import VideoClip
from moviepy.video.io.VideoFileClip import VideoFileClip
import face_recognition
import cv2
from moviepy.editor import TextClip
import numpy as np


def text_to_speech(text, language='en'):
    tts = gTTS(text=text, lang=language, slow=False)
    return tts


def create_avatar_video(text, video_output_path='avatar_video.mp4'):
    # Text to Speech
    tts = text_to_speech(text)
    tts.save("temp.mp3")

    # Load video clip with a face
    video_clip = VideoFileClip("path/to/your_video.mp4")  # Replace with the path to your video
    video_duration = video_clip.duration

    # Load face landmarks
    face_image = face_recognition.load_image_file("path/to/your_face_image.jpg")  # Replace with the path to a face image
    face_landmarks = face_recognition.face_landmarks(face_image)[0]

    # Extract mouth region
    mouth_top = min(np.array(face_landmarks['top_lip']).T[1])
    mouth_bottom = max(np.array(face_landmarks['bottom_lip']).T[1])

    # Define a function for creating frames with animated text
    def make_frame(t):
        frame = video_clip.get_frame(t)
        txt_clip = TextClip(text, fontsize=24, color='white', bg_color='black')
        txt_clip = txt_clip.set_pos(('center', 'bottom')).set_duration(video_duration)
        txt_clip = txt_clip.set_position(('center', mouth_bottom - 20))
        frame = frame.copy()
        frame.paste(txt_clip.get_frame(t))
        return frame

    # Create the final video with animated text
    final_video = VideoClip(make_frame, duration=video_duration)

    # Write the video to a file
    final_video.write_videofile(video_output_path, codec='libx264', audio="temp.mp3", fps=24)

    # Remove temporary audio file
    os.remove("temp.mp3")


if __name__ == "__main__":
    input_text = "Hello, this is a test."
    create_avatar_video(input_text)
