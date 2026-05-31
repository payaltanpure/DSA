class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long planetMass = mass;   // use long

        for(int asteroid : asteroids)
        {
            if(planetMass < asteroid)
            {
               return false;
            }
            planetMass += asteroid;
        }

        return true;
    }
}


// Let's understand the problem in simple words.

// What is given?
// A planet with initial mass = mass
// Several asteroids with masses stored in asteroids[]
// Rule of collision

// When the planet collides with an asteroid:

// ✅ If planet_mass >= asteroid_mass

// The asteroid is destroyed.
// The planet absorbs it and gains its mass.
// New mass = planet_mass + asteroid_mass

// ❌ If planet_mass < asteroid_mass

// The planet is destroyed.
// Game over.
// Goal

// You can choose the collision order however you want.

// Return:

// true → if there exists some order that destroys all asteroids.
// false → if it's impossible.
// Example 1
// Input
// mass = 10
// asteroids = [3,9,19,5,21]

// A good order is:

// [9,19,5,3,21]
// Step 1

// Planet = 10

// 10 >= 9

// Destroy asteroid.

// New mass:

// 10 + 9 = 19
// Step 2

// Planet = 19

// 19 >= 19

// Destroy asteroid.

// New mass:

// 19 + 19 = 38
// Step 3

// Planet = 38

// 38 >= 5

// New mass:

// 38 + 5 = 43
// Step 4

// Planet = 43

// 43 >= 3

// New mass:

// 43 + 3 = 46
// Step 5

// Planet = 46

// 46 >= 21

// New mass:

// 46 + 21 = 67

// All asteroids destroyed.

// Answer = true

// Example 2
// Input
// mass = 5
// asteroids = [4,9,23,4]

// Let's destroy the small ones first.

// Step 1
// 5 >= 4

// New mass:

// 5 + 4 = 9
// Step 2
// 9 >= 9

// New mass:

// 9 + 9 = 18
// Step 3
// 18 >= 4

// New mass:

// 18 + 4 = 22
// Step 4

// Now asteroid mass is:

// 23

// But planet mass is:

// 22

// Since

// 22 < 23

// Planet gets destroyed.

// No matter what order you choose, before fighting 23, the maximum mass you can reach is:

// 5 + 4 + 9 + 4 = 22

// Still less than 23.

// So destroying all asteroids is impossible.

// Answer = false

// Key Observation

// To maximize the planet's growth, always destroy the smallest asteroid available first.

// Why?

// Suppose:

// Planet = 10
// Asteroids = [3, 100]

// If you fight 100 first:

// 10 < 100

// Lose immediately.

// If you fight 3 first:

// 10 + 3 = 13

// You become stronger.

// This suggests:

// 👉 Sort the asteroids in increasing order and process them one by one.

// smallest → largest

// If at any point:

// mass < asteroid

// return false.

// Otherwise keep adding masses and finally return true.

// Greedy Idea
// 1. Sort asteroids.
// 2. For each asteroid:
//       if mass < asteroid:
//             return false
//       mass += asteroid
// 3. return true

// This works because destroying smaller asteroids first gives the planet the maximum possible chance to grow before facing larger asteroids.

// explain example no 2

// Let's go through Example 2 very carefully.

// Input
// mass = 5
// asteroids = [4, 9, 23, 4]

// Planet's initial mass = 5

// Try the best possible order

// Since we can choose any order, we'll destroy the smallest asteroids first.

// Sorted asteroids:

// [4, 4, 9, 23]
// Collision 1

// Planet = 5

// Asteroid = 4

// 5 >= 4

// Asteroid destroyed.

// New planet mass:

// 5 + 4 = 9
// Collision 2

// Planet = 9

// Asteroid = 4

// 9 >= 4

// Asteroid destroyed.

// New planet mass:

// 9 + 4 = 13
// Collision 3

// Planet = 13

// Asteroid = 9

// 13 >= 9

// Asteroid destroyed.

// New planet mass:

// 13 + 9 = 22
// Collision 4

// Planet = 22

// Asteroid = 23

// Check:

// 22 >= 23 ?

// No.

// 22 < 23

// Planet gets destroyed.

// So answer becomes:

// false
// Why can't another order work?

// Let's check.

// The total mass of all smaller asteroids is:

// 4 + 4 + 9 = 17

// Initial planet mass:

// 5

// Maximum mass possible before fighting 23:

// 5 + 17 = 22

// Even after eating every other asteroid, the planet can only become:

// 22

// But asteroid is:

// 23

// Since

// 22 < 23

// the planet can never destroy asteroid 23.

// Visualization
// Initial Planet = 5

// Destroy 4  -> 9
// Destroy 4  -> 13
// Destroy 9  -> 22

// Need to destroy 23

// 22 < 23 ❌

// Therefore:

// return false;

// The key idea is: even after absorbing all other asteroids, the planet's maximum possible mass is 22, which is still smaller than 23. Hence asteroid 23 can never be destroyed.

// the order we use of asteroids  to compare  how we decide that order 

// Excellent question. This is the main idea of the problem.

// How do we decide the order?

// We choose the order that gives the planet the maximum chance to grow.

// That means:

// 👉 Always destroy the smallest asteroid first.

// Why?

// Because every asteroid you destroy increases your mass.

// Example
// mass = 10
// asteroids = [3, 20]
// Order 1: [20, 3]

// Planet = 10

// 10 < 20

// Planet dies immediately ❌

// Order 2: [3, 20]

// Planet = 10

// 10 >= 3

// Destroy 3

// New mass:

// 10 + 3 = 13

// Now:

// 13 < 20

// Still dies ❌

// Not enough, but at least mass increased.

// Another Example
// mass = 10
// asteroids = [3, 9, 20]
// Sorted order
// [3, 9, 20]

// Planet = 10

// 10 >= 3

// Mass = 13

// 13 >= 9

// Mass = 22

// 22 >= 20

// Mass = 42

// All destroyed ✅

// Why is sorting correct?

// Suppose there are two asteroids:

// a = 5
// b = 20

// If you can destroy 20, then you can definitely destroy 5.

// Destroying 5 first makes your mass larger before facing 20.

// So:

// Small → Large

// is always at least as good as

// Large → Small

// and often much better.

// That's why the greedy strategy is:

// Arrays.sort(asteroids);

// for(int asteroid : asteroids)
// {
//     if(mass < asteroid)
//         return false;

//     mass += asteroid;
// }

// return true;
// Intuition

// Think of it like a game character:

// Small enemies give experience points.
// Experience makes you stronger.
// Stronger characters can defeat bigger enemies.

// So you fight:

// Level 1 enemy
// → gain power

// Level 2 enemy
// → gain power

// Level 10 boss

// instead of directly fighting the boss.

// That's exactly why we sort the asteroids in ascending order.