package com.uls.practica_3

import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import java.util.Timer
import java.util.TimerTask


data class Song(
    val name: String,
    val resourceId: Int
)
class MediaActivity : AppCompatActivity() {

    var playlist = listOf<Song>(
        Song("Mantis Lords", R.raw.mantis_lords),
        Song("City of Tears", R.raw.city_of_tears),
        Song("Greenpath", R.raw.greenpath),
    )
    var currentIndex = 0

    var isPlaying = false
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var playPauseButton: MaterialButton
    private lateinit var currentSongName: TextView
    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media)

        val toolbar = findViewById<Toolbar>(R.id.materialToolbar)

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        playPauseButton = findViewById(R.id.btn_play_pause)
        currentSongName = findViewById(R.id.currentSongName)
        seekBar = findViewById(R.id.seekBar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        // Update SeekBar periodically
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                try {
                    if (mediaPlayer != null) {
                        seekBar.progress = mediaPlayer!!.currentPosition
                    }
                } catch (e: IllegalStateException) {
                    // Handle the exception, e.g., when MediaPlayer is not initialized
                }
            }
        }, 0, 1000) // Update every 1 second
    }

    fun changeSongName(song: Song) {
        currentSongName.text = song.name
    }
    fun playSong(view: View) {
        if (mediaPlayer == null) {
            seekBar.progress = 0;
            val song = playlist[currentIndex]
            changeSongName(song)
            mediaPlayer = MediaPlayer.create(this, song.resourceId)
            seekBar.max = mediaPlayer!!.duration

            mediaPlayer?.setOnCompletionListener {
                nextSong(view)
            }

        }

        mediaPlayer?.start()
        isPlaying = true
    }

    fun pauseSong(view: View) {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
            isPlaying = false
        }
    }

    fun togglePlayPause(view: View) {
        if (mediaPlayer?.isPlaying == true) {
            pauseSong(view)
            playPauseButton.setIconResource(android.R.drawable.ic_media_play)
        } else {
            playSong(view)
            playPauseButton.setIconResource(android.R.drawable.ic_media_pause)
        }
    }

    fun setMediaPlayer(song: Song, view: View) {
        mediaPlayer?.release()
        mediaPlayer = null
        seekBar.progress = 0;

        changeSongName(song)
        mediaPlayer = MediaPlayer.create(this, song.resourceId)
        mediaPlayer?.start()
        seekBar.max = mediaPlayer!!.duration
        mediaPlayer?.setOnCompletionListener {
            nextSong(view)
        }
    }

    fun nextSong(view: View) {
        currentIndex++

        if (currentIndex >= playlist.size) {
            currentIndex = 0
        }

        val song = playlist[currentIndex]
        setMediaPlayer(song, view)
    }

    fun previousSong(view: View) {
        currentIndex--

        if (currentIndex < 0) {
            currentIndex = playlist.size - 1
        }

        val song = playlist[currentIndex]
        setMediaPlayer(song, view)
    }
}