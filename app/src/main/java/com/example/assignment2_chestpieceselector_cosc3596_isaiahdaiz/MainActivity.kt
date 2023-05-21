package com.example.assignment2_chestpieceselector_cosc3596_isaiahdaiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var uIVsilibity = true;
    private var color = "White";
    private var piece = "King";

    private lateinit var textViewColour: TextView;
    private lateinit var textViewPiece: TextView;
    private lateinit var toggleButton: ToggleButton;
    private lateinit var radioButtonWhite: RadioButton;
    private lateinit var radioButtonBlack: RadioButton;
    private lateinit var spinner: Spinner;
    private lateinit var imageView: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assign widgets, buttons, textview
        textViewColour = findViewById(R.id.textViewColour);
        textViewPiece = findViewById(R.id.textViewPiece);
        toggleButton = findViewById(R.id.toggleButton);
        radioButtonWhite = findViewById(R.id.radioButtonWhite);
        radioButtonBlack = findViewById(R.id.radioButtonBlack);
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        // Onclick listeners
        // Toggle button
        toggleButton.setOnClickListener { view ->
            uIVsilibity = !uIVsilibity;
            updateUI();
        }

        // Color Picker
        radioButtonWhite.setOnClickListener {  view ->
            color = "White";
            println(color);
            updateImageView();
        }

        radioButtonBlack.setOnClickListener {  view ->
            color = "Black";
            println(color);
            updateImageView();
        }

        // Piece Picker
        // access the spinner
        val spinnerSelection = resources.getStringArray(R.array.spinnerSelection)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, spinnerSelection)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    println(spinnerSelection[position]);
                    piece = spinnerSelection[position];
                    updateImageView();
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // This is intentionally left blank
                }
            }
        }
    }

    // Show / Hide UI
    private fun updateUI() {
        radioButtonBlack.visibility = if (uIVsilibity) View.VISIBLE else View.GONE;
        radioButtonWhite.visibility = if (uIVsilibity) View.VISIBLE else View.GONE;
        spinner.visibility = if (uIVsilibity) View.VISIBLE else View.GONE;
        imageView.visibility = if (uIVsilibity) View.VISIBLE else View.GONE;
        textViewPiece.visibility = if (uIVsilibity) View.VISIBLE else View.GONE;
        textViewColour.visibility = if (uIVsilibity) View.VISIBLE else View.GONE;
    }

    // Change chess piece
    private fun updateImageView() {
        println("Updating ImageView");
        if (color == "White" && piece == "King")
            imageView.setImageResource(R.drawable.white_king);
        else if (color == "White" && piece == "Queen")
            imageView.setImageResource(R.drawable.white_queen);
        else if (color == "White" && piece == "Rook")
            imageView.setImageResource(R.drawable.white_rook);
        else if (color == "White" && piece == "Bishop")
            imageView.setImageResource(R.drawable.white_bishop);
        else if (color == "White" && piece == "Knight")
            imageView.setImageResource(R.drawable.white_knight);
        else if (color == "White" && piece == "Pawn")
            imageView.setImageResource(R.drawable.white_pawn);
        else if (color == "Black" && piece == "King")
            imageView.setImageResource(R.drawable.black_king);
        else if (color == "Black" && piece == "Queen")
            imageView.setImageResource(R.drawable.black_queen);
        else if (color == "Black" && piece == "Rook")
            imageView.setImageResource(R.drawable.black_rook);
        else if (color == "Black" && piece == "Bishop")
            imageView.setImageResource(R.drawable.black_bishop);
        else if (color == "Black" && piece == "Knight")
            imageView.setImageResource(R.drawable.black_knight);
        else if (color == "Black" && piece == "Pawn")
            imageView.setImageResource(R.drawable.black_pawn);
    }
}