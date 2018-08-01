require 'pry'

def welcome
  puts "Help me help you decide whether to visit a restaurant."
end

def get_character_from_user
  puts "Please enter the name of a restaurant you're considering: "
  # use gets to capture the user's input. This method should return that input, downcased.
  resto = gets.chomp.downcase

end
